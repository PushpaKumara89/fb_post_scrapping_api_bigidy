package com.wixis.bigidy;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.wixis.bigidy.activity.db.DataSourceConfig;
import com.wixis.bigidy.activity.modle.Page;
import com.wixis.bigidy.activity.service.PostDetailsService;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

class BigidyApplicationTests {

	public static void main(String[] args) {
		PostDetailsService n= new PostDetailsService(new DataSourceConfig().dataSource());
		List<Page> a = n.getPages("a");
		System.out.println(a);

	}
}
