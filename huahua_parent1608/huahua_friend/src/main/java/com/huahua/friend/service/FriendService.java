package com.huahua.friend.service;

import com.huahua.friend.dao.FriendDao;
import com.huahua.friend.dao.NoFriendDao;
import com.huahua.friend.entity.Friend;
import com.huahua.friend.entity.NoFriend;
import com.huahua.friend.eureka.UserEureka;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FriendService {

    @Autowired
    FriendDao friendDao;

    @Autowired
    NoFriendDao noFriendDao;

    @Autowired
    UserEureka userEureka;


    @Transactional
    public int addFriend(String userid,String friendid){
        //判断用户已经添加了这个好友，则不进行任何操作，并且返回0
        if (friendDao.selectByUserCount(userid,friendid)>0){
            return 0;
        }
        //如何没有添加  向喜欢表中添加记录
        Friend friend = new Friend();
        friend.setUserid(userid);
        friend.setFriendid(friendid);
        friend.setIslike("0");
        friendDao.save(friend);
        //判断对方是否也喜欢你  如何喜欢你，则双方islike 设置1
        if (friendDao.selectByUserCount(friendid,userid)>0){
            friendDao.updateLike(userid,friendid,"1");
            friendDao.updateLike(friendid,userid,"1");
        }
        //调用spring cloud 微服务 修改用户表的关注数， 粉丝数
        userEureka.incfollowCount(userid,1);
        userEureka.incfansCount(userid,1);
        return 1;
    }

    @Transactional
    public void notLikeFriend(String userid, String friendid) {
        friendDao.deleteById(userid);
        //判断是否互相关注
        //如果互相互粉  则修改friendid用户中 islike
        if (friendDao.selectByUserCount(friendid,userid)>0){
            friendDao.updateLike(friendid,userid,"0");
        }
        //调用spring cloud 微服务 修改用户表的关注数，粉丝数
        try {
            userEureka.incfollowCount(userid,-1);
            userEureka.incfansCount(userid,-1);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Transactional
    public void delete(String userid, String friendid) {
        //判断当前用户是否喜欢过对方
        if (friendDao.selectByUserCount(userid,friendid)>0){
            //user 修改是关注数
            userEureka.incfollowCount(userid,-1);
            //friendId 修改是粉丝数
            userEureka.incfansCount(friendid,-1);
        }
        //删除我关注用户的那条记录
        friendDao.deleteByuseridAndFriendid(userid,friendid);
        //如何使互粉的情况下，拉黑的话，friend islike 改为0
        if (friendDao.selectByUserCount(friendid,userid)>0){
            friendDao.updateLike(friendid,userid,"0");
        }
        //tb_nofriend表中插入一条记录
        NoFriend noFriend = new NoFriend();
        noFriend.setFriendid(friendid);
        noFriend.setUserid(userid);
        noFriendDao.save(noFriend);
        //调用spring cloud 微服务 修改用户表的关注数，粉丝数
        userEureka.incfollowCount(userid,-1);
        userEureka.incfansCount(userid,-1);
    }
}
