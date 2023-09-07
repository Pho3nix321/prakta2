    package com.example.prakta2.controller;


    import com.example.prakta2.dao.AnimeDAO;
    import com.example.prakta2.models.AnimeModel;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.*;

    @Controller
    @RequestMapping("/anime")
    public class  AnimeController {

        private final AnimeDAO _animeDao;

        @Autowired
        public AnimeController(AnimeDAO animeDAO){
            this._animeDao = animeDAO;
        }

        @GetMapping()
        public String index(Model model){
            model.addAttribute("Anime", _animeDao.index());
            return "anime/index";
        }

        @GetMapping("/{id}")
        public String show(@PathVariable("id") int id, Model model){
            model.addAttribute("Anime", _animeDao.show(id));
            return "anime/show";
        }


        @GetMapping("/new")
        public String newAnime(@ModelAttribute("Anime") AnimeModel animeModel){
            return "anime/new";
        }

        @PostMapping()
        public String create(@ModelAttribute("Anime") AnimeModel animeModel){
            _animeDao.save(animeModel);
            return "redirect:/anime";
        }


        @GetMapping("/{id}/edit")
        public String edit(Model model, @PathVariable("id") int id){
            model.addAttribute("Anime",_animeDao.show(id));
            return "anime/edit";
        }

        @PatchMapping("/{id}")
        public String update(@ModelAttribute("Anime") AnimeModel animeModel, @PathVariable("id") int id){
            _animeDao.update(id,animeModel);
            return "redirect:/anime";
        }

        @DeleteMapping("/{id}")
        public String delete(@PathVariable("id") int id){
            _animeDao.delete(id);
            return "redirect:/anime";
        }


    }


