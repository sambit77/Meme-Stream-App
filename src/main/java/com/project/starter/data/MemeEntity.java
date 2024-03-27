package com.project.starter.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(collection = "memes")
@NoArgsConstructor
public class MemeEntity {
    @Id
    private int id;
    //@Indexed(unique = true)
    private String name;
    //@Indexed(unique = true)
    private String caption;
    //@Indexed(unique = true)
    private String url;
}
