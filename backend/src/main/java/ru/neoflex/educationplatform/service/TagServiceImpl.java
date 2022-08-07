package ru.neoflex.educationplatform.service;

import lombok.RequiredArgsConstructor;
import org.openapitools.model.SimpleResponseDto;
import org.springframework.stereotype.Service;
import ru.neoflex.educationplatform.mapper.InterestTagMapper;
import ru.neoflex.educationplatform.repository.InterestTagRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService{
    private final InterestTagRepository tagRepository;
    private final InterestTagMapper tagMapper;

    @Override
    public List<SimpleResponseDto> getAllTags() {
        return tagRepository.findAll().stream().map(tagMapper::mapEntityToDto).collect(Collectors.toList());
    }
}
