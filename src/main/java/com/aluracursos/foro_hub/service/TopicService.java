package com.aluracursos.foro_hub.service;

import com.aluracursos.foro_hub.entity.Topic;
import com.aluracursos.foro_hub.repository.TopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TopicService {

    private final TopicRepository topicRepository;

    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    public Topic getTopicById(Long topicId) {
        return topicRepository.findById(topicId)
                .orElseThrow(() -> new RuntimeException("Topic not found"));
    }

    public Topic createTopic(Topic topic) {
        return topicRepository.save(topic);
    }

    public Topic updateTopic(Long topicId, Topic topic) {
        Topic topicUpdated = topicRepository.findById(topicId)
                .orElseThrow(() -> new RuntimeException("Topic not found"));
        topicUpdated.setTitulo(topic.getTitulo());
        topicUpdated.setMensaje(topic.getMensaje());
        topicUpdated.setStatus(topic.getStatus());
        return topicRepository.save(topicUpdated);
    }

    public String deleteTopic(Long topicId) {
        Topic topicDeleted = topicRepository.findById(topicId)
                .orElseThrow(() -> new RuntimeException("Topic not found"));
        topicRepository.delete(topicDeleted);
        return "Topic deleted successfully";
    }
}
