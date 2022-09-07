package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TodoEntity {
    private String id; //Object id
    private String userId; //User id who create this object
    private String title; //Todo title(etc. go to gym..)
    private boolean done; //if complete the 'todo', it will be true
}
