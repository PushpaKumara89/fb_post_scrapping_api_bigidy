package com.wixis.bigidy.activity.service;

import com.wixis.bigidy.activity.db.DBConnection;
import com.wixis.bigidy.activity.modle.Page;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Service
public class PostDetailsService {

    public ArrayList<String> getScreenShots(String txt){
        try {
            PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement("select img_url from post po left join post_imgs pi on pi.post_id=po.id where po.post_by LIKE '%" + txt + "%'");
            ResultSet set = stm.executeQuery();
            ArrayList<String> list= new ArrayList<>();
            while (set.next()){
                list.add(set.getString(1));
            }
            return list;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Set<Page> getPages(String txt){
        try {
            PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement("select * from page where page_name LIKE '%"+ txt +"%' ");
            ResultSet rst = stm.executeQuery();
            Set<Page> list =new HashSet<>();
            while (rst.next()){
                list.add(new Page(
                        rst.getInt(1),
                        rst.getString(2),
                        rst.getString(3),
                        rst.getString(4),
                        rst.getString(5),
                        rst.getBoolean(6),
                        rst.getString(7)
                ));
            }
            return list;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
