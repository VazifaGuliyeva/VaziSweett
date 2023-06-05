package com.example.vazisweet.manager;

import com.example.vazisweet.dto.KateqoriyaDto;
import com.example.vazisweet.dto.KateqoriyaDtoManager;
import com.example.vazisweet.dto.KateqoriyaPageResponse;
import com.example.vazisweet.entity.Category;
import com.example.vazisweet.exception.KateqoriyaNotFoundException;
import com.example.vazisweet.mapper.KateqoriyaMapper;
import com.example.vazisweet.repository.KateqoriyaRepository;
import com.example.vazisweet.service.KateqoriyaService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class KateqoriyaManager implements KateqoriyaService {
    private final KateqoriyaRepository kateqoriyaRepository;
    private final KateqoriyaDtoManager kateqoriyaDtoManager;

    private final KateqoriyaMapper kateqoriyaMapper;

    @Override
    public KateqoriyaPageResponse getAll(int page, int count) {

        Page<Category> kateqoriyaPage=kateqoriyaRepository.findAll(PageRequest.of(page,count));


        return new KateqoriyaPageResponse(
                kateqoriyaPage.getContent().stream().map(kateqoriyaMapper::toKateqoriyaDto).toList(),
                kateqoriyaPage.getTotalElements(),
                kateqoriyaPage.getTotalPages(),
                kateqoriyaPage.hasNext()
        );
    }

    @Override
    public KateqoriyaDto getById(int id) {
        return kateqoriyaRepository.findById(id).
                stream().map(kateqoriyaMapper :: toKateqoriyaDto).findFirst().
                orElseThrow(()-> new KateqoriyaNotFoundException("kateqoriya tapilmadi"));
    }



    @Override
    public void addKateqoriya(KateqoriyaDto kateqoriyaDto) {
        kateqoriyaRepository.save(kateqoriyaMapper.toEntity(kateqoriyaDto));

    }

    @Override
    public void deleteKateqoriya(int id) {
        kateqoriyaRepository.deleteById(id);

    }
}
