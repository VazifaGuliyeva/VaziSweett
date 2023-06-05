package com.example.vazisweet.manager;

import com.example.vazisweet.dto.MehsulDto;
import com.example.vazisweet.dto.MehsulDtoManager;
import com.example.vazisweet.dto.MehsulPageResponse;
import com.example.vazisweet.entity.Mehsul;
import com.example.vazisweet.exception.MehsulNotFoundException;
import com.example.vazisweet.mapper.MehsulMapper;
import com.example.vazisweet.repository.MehsulRepository;
import com.example.vazisweet.service.MehsulService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MehsulManager implements MehsulService {
    private final MehsulRepository mehsulRepository;
    private final MehsulDtoManager mehsulDtoManager;

    private final MehsulMapper mehsulMapper;


    @Override
    public MehsulPageResponse getAll(int page, int count) {

        Page<Mehsul> mehsulPage=mehsulRepository.findAll(PageRequest.of(page,count));


        return new MehsulPageResponse(
                mehsulPage.getContent().stream().map(mehsulMapper::toMehsulDto).toList(),
                mehsulPage.getTotalElements(),
                mehsulPage.getTotalPages(),
                mehsulPage.hasNext()
        );
    }

    @Override
    public MehsulDto getById(int id) {
        return mehsulRepository.findById(id).stream().
                map(mehsulMapper :: toMehsulDto).findFirst().
                orElseThrow(()-> new MehsulNotFoundException("mehsul tapilmadi"));


    }

    @Override
    public void addMehsul(MehsulDto mehsulDto) {
        mehsulRepository.save(mehsulMapper.toEntity(mehsulDto));

    }

    @Override
    public void deleteMehsul(int id) {
        mehsulRepository.deleteById(id);
    }
}
