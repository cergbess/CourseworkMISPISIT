package com.example.concerts.controller;

import com.example.concerts.model.Scene;
import com.example.concerts.service.SceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;

@Controller
public class SceneController {
    @Autowired
    SceneService sceneService;

    @GetMapping({"/viewSceneList"})
    public String viewSceneList(@ModelAttribute("message")String message, Model model){
        getScenesByFullName("", model);
        model.addAttribute("sceneList",sceneService.getAllScenes());
        model.addAttribute("message", message);
        return "ViewSceneList";
    }
    @GetMapping({"/AddScene"})
    public String AddScene(@ModelAttribute("message") String message,Model model){
        model.addAttribute("scene",new Scene());
        model.addAttribute("message",message);
        return "AddScene";
    }

    @PostMapping("/saveScene")
    public String saveScene(Scene scene, RedirectAttributes redirectAttributes){
        if (sceneService.saveOrUpdateScene(scene)){
            redirectAttributes.addFlashAttribute("message", "Save Success");
            return "redirect:/viewSceneList";
        }
        redirectAttributes.addFlashAttribute("message","Save Failure");
        return "redirect:/AddScene";
    }

    @GetMapping("/editScene/{id}")
    public String editScene(@PathVariable Long id, Model model){
        model.addAttribute("scene",sceneService.getSceneById(id));
        return "EditScene";
    }
    @PostMapping("/editSaveScene")
    public String editSaveScene(Scene scene, RedirectAttributes redirectAttributes) {
        if (sceneService.saveOrUpdateScene(scene)) {
            redirectAttributes.addFlashAttribute("message", "Edit Success");
            return "redirect:/viewSceneList";
        }

        redirectAttributes.addFlashAttribute("message", "Edit Failure");
        return "redirect:/editScene/" + scene.getId();
    }
    @GetMapping("/deleteScene/{id}")
    public String deleteScene(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        if (sceneService.deleteScene(id)) {
            redirectAttributes.addFlashAttribute("message", "Delete Success");
        } else {
            redirectAttributes.addFlashAttribute("message", "Delete Failure");
        }

        return "redirect:/viewSceneList";
    }
    @GetMapping("/getScenesByFullName")
    public String getScenesByFullName(@RequestParam(value = "scenename", required = false) String scenename, Model model) {
        List<Scene> scenes;
        if (scenename != null && !scenename.isEmpty()) {
            scenes = Collections.singletonList(sceneService.getScenesBySceneName(scenename));
        } else {
            scenes = sceneService.getAllScenes();
        }

        if (scenes != null) {
            model.addAttribute("message", "Get Success");
        } else {
            model.addAttribute("message", "Get Failure");
        }
        model.addAttribute("scenes", scenes);
        return "ViewSceneList";
    }
}
