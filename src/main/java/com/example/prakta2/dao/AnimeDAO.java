package com.example.prakta2.dao;

import com.example.prakta2.models.AnimeModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AnimeDAO {

    private static int ANIME_COUNT;
    private List<AnimeModel> Anime;
    {
        Anime = new ArrayList<>();

        Anime.add(new AnimeModel(++ANIME_COUNT,"Джо-Джо","Галеб",3));
        Anime.add(new AnimeModel(++ANIME_COUNT,"Токийские мстители","Сыньпьюкунь",7));


    }

    public List<AnimeModel> index(){

        return Anime;
    }

    public AnimeModel show(int id){
        return Anime.stream().filter(animeModel -> animeModel.getId() == id).findAny().orElse(null);
    }

    public void save(AnimeModel anime){
        anime.setId(++ANIME_COUNT);
        Anime.add(anime);
    }

    public void update(int id, AnimeModel animeModel){
        AnimeModel updateAnime = show(id);
        updateAnime.setName(animeModel.getName());
        updateAnime.setAuthor(animeModel.getAuthor());
        updateAnime.setRating(animeModel.getRating());

    }


    public void delete(int id){
        Anime.removeIf(p-> p.getId() == id);
    }

}
