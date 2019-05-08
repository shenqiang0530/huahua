package com.huahua.spit.controller;

import com.huahua.spit.entity.Spit;
import com.huahua.spit.service.SpitService;
import huahua.common.PageResult;
import huahua.common.Result;
import huahua.common.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/spit")
@CrossOrigin
public class SpitController {

    @Autowired
    private SpitService spitService;

    @Autowired
    private RedisTemplate redisTemplate;

    /*
    *
    * */
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        return new Result(true, StatusCode.OK,"查询成功",spitService.findAll());
    }
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    public Result findByid(@PathVariable String id){
        return new Result(true, StatusCode.OK,"查询成功",spitService.findById(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result add(@RequestBody Spit spit){
        spit.setPublishtime(new Date());
        spitService.add(spit);
        return new Result(true, StatusCode.OK,"增加成功");
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/{id}")
    public Result update(@PathVariable Spit spit,@PathVariable String id){
        spit.set_id(id);
        spitService.update(spit);
        return new Result(true, StatusCode.OK,"修改成功");
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/{id}")
    public Result delete(@PathVariable String id){
        spitService.delete(id);
        return new Result(true, StatusCode.OK,"删除成功");
    }


    /*
    * 根据上级ID查询吐槽数据（分页）
    * */
    @RequestMapping(method = RequestMethod.GET,value = "/comment/{parentid}/{page}/{size}")
    public Result findByPidList(@PathVariable("parentid") String parentid,@PathVariable("page" ) Integer page,@PathVariable("size") Integer size){

        Page<Spit> spitList = spitService.findByPidList(parentid,page,size);
        return new Result(true,StatusCode.OK,"查询成功",new PageResult<>(spitList.getTotalElements(),spitList.getContent()));

    }

    /*
    * 吐槽点赞
    * */
    @RequestMapping(method = RequestMethod.POST,value = "/thumbup/{spitId}")
    public Result updateThumbup(@PathVariable("spitId") String spitId){
        String userid="2023";
        if(redisTemplate.opsForValue().get("thumbup_"+userid+"_"+ spitId)!=null){
            return new Result(false,StatusCode.OK,"你已经点过赞了");
        }
        spitService.updateThumbup(spitId);
        redisTemplate.opsForValue().set( "thumbup_"+userid+"_"+ spitId,"1");
        return new Result(true,StatusCode.OK,"点赞成功");
    }
}
