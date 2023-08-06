package jsp.servlet.service;

import jsp.servlet.dto.MemberDto;
import jsp.servlet.dto.NewsDto;
import jsp.servlet.entity.News;
import jsp.servlet.repository.NewsRepository;

import java.util.LinkedList;
import java.util.List;

public class NewsService {
    private static final NewsRepository newsRepository = new NewsRepository();
    public void addNews(NewsDto newsDto){
        newsRepository.save(new News(newsDto.getTitle(),
                                newsDto.getImg(),
                                newsDto.getContent(),
                                newsDto.getM_id()));
    }

    public List<MemberDto> listNews(){
        return new LinkedList<>();
    }
    public NewsDto detailNews(){

        return new NewsDto();
    }

    public void deleteNews(){

    }

}
