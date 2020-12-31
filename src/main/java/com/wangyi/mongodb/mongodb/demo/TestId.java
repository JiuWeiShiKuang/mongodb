package com.wangyi.mongodb.mongodb.demo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

/**
 * @Description:
 * @author: wy
 */
@Data
@Document(collection = "test_id")
public class TestId implements Serializable {
    private static final long serialVersionUID = -3258839839160856613L;
    @AutoIncKey
    @Id
//    @Field("id")
    private String id;
    @Field("user_name")
    private String userName;
    @Field("password")
    private String password;

}
