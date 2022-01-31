package com.example.ProjetProgWeb;

import com.example.ProjetProgWeb.entities.Commentaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin(origins = "http://localhost:777")
@RestController
public class WebServices {


  /* private ProfessionalRepository ProRep;
    private AnnounceRepository PostsRep;
    private AnswerRepository AnsRep;

    @Autowired
    public WebServices(ProfessionalRepository Repo1, AnnounceRepository Repo2,AnswerRepository Repo3) {
        super();
        this.ProRep = Repo1;
        this.PostsRep = Repo2;
        this.AnsRep= Repo3;
    }

    //Welcome
    @RequestMapping(value="/", method= RequestMethod.GET)
    public String Welcome(){
        return "Welcome to the Webservices of our plateforme";
    }

    //Get All Pro users
    @GetMapping("/Pros")
    public List<Professional> getListOfPros(){
        System.out.println(" Liste des Utilisateurs Pro :");
        List<Professional> all = DataInitializer.pros;
        return all;
    }

    //Post new user
    @PostMapping("/Pros")
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void addPro(@RequestBody Professional pro) throws Exception{
        for(Professional Pro1 : DataInitializer.pros){
            if(Pro1.getUsername().equals(pro.getUsername()) ){
                throw new Exception();
            }
        }
        DataInitializer.pros.add(pro);
        ProRep.save(pro);
        System.out.println(pro.getUsername()+" Ajouté");
    }

    //Get Pro-user
    @GetMapping("/Pros/{username}")
    public Professional getpro(@PathVariable(value = "username") String username){
        for(Professional pro: DataInitializer.pros){
            if(pro.getUsername().equals(username)){
                return pro;
            }
        }
        return null;
    }

    //Get all Posts
    @GetMapping("/Posts")
    public List<Announcement> getListOfPosts(){
        System.out.println(" Posts:");
        return DataInitializer.posts;
    }

    //Add Post
    /*@PostMapping("/Posts")
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void newpost(@RequestBody Announcement pro) throws Exception{
        for(Professional Pro1 : DataInitializer.pros){
            boolean test = false;
            if(Pro1.getUsername().equals(pro.getUsername()) ){
                test = true;
                break;
            }
        }
        DataInitializer.pros.add(post);
        ProRep.save(pro);
        System.out.println(pro.getUsername()+" Ajouté");
    }
    @PostMapping("/Posts")
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void newpost(@RequestBody Announcement post) throws Exception {
        boolean test = false;
        for (Professional pro : DataInitializer.pros) {
            if (pro.getUsername().equals(post.getOwner().getUsername())) {
                test = true;
                post.setOwner(pro);
                break;
            }
            if (test = false) throw new Exception();
        }
        System.out.println(post.getTitle());
        post.setDateNow();
        DataInitializer.posts.add(post);
        PostsRep.save(post);
    }


    @GetMapping("/Posts/{id}")
    public Announcement getpost(@PathVariable(value = "id") Long id){
        for(Announcement post: DataInitializer.posts){
            if(post.getId().equals(id)){
                return post;
            }
        }
        return null;
    }


    @GetMapping("/Posts/{id}/comments")
    public List<Commentaire> getAnswers(@PathVariable(value = "id") Long id){
        List<Commentaire> Answers = new ArrayList<Commentaire>();
        for(Commentaire Answer: DataInitializer.Answers){
            if(Answer.getPost().getId().equals(id)){
                Answers.add(Answer);
            }
        }
        return Answers;
    } */

    //Add Comment
    /*@PostMapping("/Posts/{id}")
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void newcomment(@RequestBody String[] buffer) throws Exception {
         boolean test1 = false;
         boolean test2 = false;
         Personne P = new Personne();
         Announcement A = new Announcement();
        for(Announcement post : DataInitializer.posts){
            String id = ""+post.getId();
            if (id.equals(buffer[2])) {
                test1 = true;
                A=post; 
                break;
            }
        }
       for (Professional pro : DataInitializer.pros) {
            if (pro.getUsername().equals(equals(buffer[1]))) {
                test2 = true;
                P=pro; 
                break;
            }
            if (test1 == false || test2 == false) throw new Exception();
        }
        Commentaire comment = new Commentaire(buffer[0],P,A);
        DataInitializer.Answers.add(comment);
        AnsRep.save(comment);
    }*/
    // NO PUT MAPPING for NOW , Ajouts des Puts par la suite dans des cas de modification de profils / posts ...etc
}
