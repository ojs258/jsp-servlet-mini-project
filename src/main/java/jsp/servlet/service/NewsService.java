package jsp.servlet.service;

import jsp.servlet.dto.NewsDto;
import jsp.servlet.entity.News;
import jsp.servlet.repository.NewsRepository;

import java.util.ArrayList;
import java.util.List;

public class NewsService {
    private static final NewsRepository newsRepository = new NewsRepository();
    public void addNews(NewsDto newsDto){
        newsRepository.save(new News(newsDto.getTitle(),
                                newsDto.getImg(),
                                newsDto.getContent(),
                                newsDto.getM_id()));
    }

    public List<NewsDto> memberNewsList(int m_id){
        List<NewsDto> newsList = new ArrayList<>();
        List<News> memberNews = newsRepository.findAllByMember(m_id);

        for (News news : memberNews) {
            newsList.add(new NewsDto(news.getId(), news.getTitle(),
                        news.getImg(),
                        news.getDate(),
                        news.getContent()));
        }
        return newsList;
    }
    public NewsDto detailNews(int n_id){
        News detail = newsRepository.findOne(n_id);
        NewsDto detailDto = new NewsDto(detail.getTitle(),
                                detail.getImg(),
                                detail.getDate(),
                                detail.getContent());

        return detailDto;
    }

    public void deleteNews(int n_id){
        newsRepository.delete(n_id);
    }
}