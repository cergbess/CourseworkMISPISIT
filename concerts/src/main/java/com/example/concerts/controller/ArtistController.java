package com.example.concerts.controller;

import com.example.concerts.model.Artist;
import com.example.concerts.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class ArtistController {
    @Autowired
    ArtistService artistService;

    @GetMapping({"/viewArtistList"})
    public String viewArtistList(@ModelAttribute("message")String message, Model model){
        getArtistsByFullName("", model);
        model.addAttribute("artistList",artistService.getAllArtists());
        model.addAttribute("message", message);
        return "ViewArtistList";
    }
    @GetMapping({"/AddArtist"})
    public String AddArtist(@ModelAttribute("message") String message,Model model){
        model.addAttribute("artist",new Artist());
        model.addAttribute("message",message);
        return "AddArtist";
    }

    @PostMapping("/saveArtist")
    public String saveArtist(Artist artist, RedirectAttributes redirectAttributes){
        if (artistService.saveOrUpdateArtist(artist)){
            redirectAttributes.addFlashAttribute("message", "Save Success");
            return "redirect:/viewArtistList";
        }
        redirectAttributes.addFlashAttribute("message","Save Failure");
        return "redirect:/AddArtist";
    }

    @GetMapping("/editArtist/{id}")
    public String editArtist(@PathVariable Long id, Model model){
    model.addAttribute("artist",artistService.getArtistById(id));
    return "EditArtist";
    }
    @PostMapping("/editSaveArtist")
    public String editSaveArtist(Artist artist, RedirectAttributes redirectAttributes) {
        if (artistService.saveOrUpdateArtist(artist)) {
            redirectAttributes.addFlashAttribute("message", "Edit Success");
            return "redirect:/viewArtistList";
        }

        redirectAttributes.addFlashAttribute("message", "Edit Failure");
        return "redirect:/editArtist/" + artist.getId();
    }
    @GetMapping("/deleteArtist/{id}")
    public String deleteArtist(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        if (artistService.deleteArtist(id)) {
            redirectAttributes.addFlashAttribute("message", "Delete Success");
        } else {
            redirectAttributes.addFlashAttribute("message", "Delete Failure");
        }

        return "redirect:/viewArtistList";
    }
    @GetMapping("/layout")
    public String showLayoutPage() {
        return "layout";
    }
    @GetMapping({"/","/main"})
    public String showMainPage() {
        return "main";
    }
    @GetMapping("/getArtistsByFullName")
    public String getArtistsByFullName(@RequestParam(value = "fullname", required = false) String fullname, Model model) {
        List<Artist> artists;
        if (fullname != null && !fullname.isEmpty()) {
            artists = artistService.getArtistsByFullName(fullname);
        } else {
            artists = artistService.getAllArtists();
        }

        if (artists != null) {
            model.addAttribute("message", "Get Success");
        } else {
            model.addAttribute("message", "Get Failure");
        }
        model.addAttribute("artists", artists);
        return "ViewArtistList";
    }
}
