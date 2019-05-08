package jwt;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class CreatJWT {

    public static void main(String[] args) {
        //jwts.builder().setId("123456789")设置id
        JwtBuilder huahuaCommunity = Jwts.builder().setId("123456789")
                .setSubject("1608V")//使用者
                //.setExpiration(new Date(new Date().getTime()+60000))
                .setIssuedAt(new Date())//jwt的签发时间
                .claim("roles","admin,teacher")
                .claim("telphone","17600170667")
                .signWith(SignatureAlgorithm.HS256, "huahuaCommunity");//加密的算法HS256 加密的签名是：huahuaCommunity
        System.out.println(huahuaCommunity.compact());
        //通过加盐的规则 huahuaCommunity。compact（）获取token令牌
    }
}
