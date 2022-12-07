package com.example.wetravel.Controller;

import com.example.wetravel.Constant.BaseResponse;
import com.example.wetravel.Constant.Constant;
import com.example.wetravel.DTO.*;
import com.example.wetravel.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("wetravel/")
@CrossOrigin
public class PostController {
    @Autowired
    PostService postService;

    @PostMapping("create/post")
    public ResponseEntity<?> createPost(@RequestBody PostDTO postDTO){
        try {
            PostDTO result =  postService.createPost(postDTO);
            return new ResponseEntity<>(new BaseResponse(200 , result , Constant.Message.CREATE_SUCCESS) , HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(new BaseResponse(400 , null , e.getMessage()) , HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("delete/post/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable Long postId){
        try {
            Boolean result =  postService.deletePost(postId);
            return new ResponseEntity<>(new BaseResponse(200 , result , Constant.Message.DELETE_SUCCESS) , HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(new BaseResponse(400 , null , e.getMessage()) , HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("get-list/post")
    public ResponseEntity<?> getListPost(@RequestParam(defaultValue = "0") Integer checkReport ,
                                         @RequestParam(defaultValue = "0") Long accountId ,
                                         @RequestParam(defaultValue = "") List<Long> topicList ,
                                         @RequestParam(defaultValue = "-1") Integer isBlock ,
                                         @RequestParam(defaultValue = "-1") Integer isPublic ,
                                         @RequestParam(defaultValue = "1") Integer page ,
                                         @RequestParam(defaultValue = "1") Integer size){
        try {
            Page<PostDTO> result =  postService.getListPost(checkReport ,accountId, isBlock, isPublic, topicList, page, size);
            return new ResponseEntity<>(new BaseResponse(200 , result , Constant.Message.SUCCESS) , HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(new BaseResponse(400 , null , e.getMessage()) , HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("create/comment")
    public ResponseEntity<?> createComment(@RequestBody CommentDTO commentDTO){
        try {
            CommentDTO result =  postService.createComment(commentDTO);
            return new ResponseEntity<>(new BaseResponse(200 , result , Constant.Message.CREATE_SUCCESS) , HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(new BaseResponse(400 , null , e.getMessage()) , HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("create/report-post")
    public ResponseEntity<?> createReportPost(@RequestBody ReportPostRequestDTO reportPostRequestDTO){
        try {
            ReportPostRequestDTO result =  postService.createReportPost(reportPostRequestDTO);
            return new ResponseEntity<>(new BaseResponse(200 , result , Constant.Message.CREATE_SUCCESS) , HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(new BaseResponse(400 , null , e.getMessage()) , HttpStatus.BAD_REQUEST);
        }
    }

}
