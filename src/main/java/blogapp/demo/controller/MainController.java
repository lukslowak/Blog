package blogapp.demo.controller;

import blogapp.demo.model.entities.Post;
import blogapp.demo.model.entities.PostComment;
import blogapp.demo.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/posts")
    public String postPage(Model model) {
        List<Post> postList = new ArrayList<>();

        Iterable<Post> postIterable = postRepository.findAll();

        for (Post post : postIterable) {
            postList.add(post);
        }

        model.addAttribute("posts", postList);

        return "posts";
    }

    @PostMapping("/addPost")
    public String addPost(@RequestParam(value = "title") String titleParam,
                          @RequestParam(value = "content") String content){

        Post post = new Post(titleParam, content);
        PostComment postComment = new PostComment();
        postComment.setComment(titleParam);

        post.addComment(postComment);
        postRepository.save(post);

        return "index";
    }

    @GetMapping("/addPost")
    public String addPost(){

        return "addPost"; // taka templatka html
    }

}
