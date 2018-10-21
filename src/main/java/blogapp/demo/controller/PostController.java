package blogapp.demo.controller;
import blogapp.demo.model.entities.Post;
import blogapp.demo.model.entities.PostComment;
import blogapp.demo.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Optional;

@Controller
public class PostController {

    @Autowired
    PostRepository postRepository; //połąćzenie z tym interfacem

    @GetMapping("/post/{postId}")
    public String post(@PathVariable Long postId, Model model) {
        Optional<Post> postOptional = postRepository.findById(postId);

        postOptional.ifPresent(post ->{
            model.addAttribute("post", post);
        });

        return "post";
    }

    @Transactional
    @RequestMapping("/delete/{postId}")
    @ResponseBody
    public String delete(@PathVariable Long postId) {
        postRepository.deleteById(postId);
        return ("Usunięto " + postId);
    }

    @PostMapping("post/addComment")
    public String addComment(@RequestParam String commentBody, @RequestParam Long postId){
        PostComment postComment = new PostComment();
        postComment.setComment(commentBody);

        Optional<Post> postOptional = postRepository.findById(postId);

        postOptional.ifPresent(post -> {
            post.addComment(postComment);
            postRepository.save(post);
        });
        return "redirect:/post/" + postId;
    }

}

