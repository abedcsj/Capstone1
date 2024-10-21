package com.example.capstone1.service.impl;

import com.example.capstone1.domain.Faq;
import com.example.capstone1.dto.FaqDto;
import com.example.capstone1.repository.FaqRepository;
import com.example.capstone1.repository.UserRepository;
import com.example.capstone1.service.FaqService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@Service
public class FaqServiceImpl implements FaqService {

    private final FaqRepository faqRepository;
    private final UserRepository userRepository;


    @Override
    public FaqDto.CreateResDto create(FaqDto.CreateReqDto param) {
        System.out.println("create");
        return faqRepository.save(param.toEntity()).toCreateResDto();
    }
    @Override
    public void update(FaqDto.UpdateReqDto param) {
        System.out.println("update");
        Faq faq = faqRepository.findById(param.getId()).orElseThrow(() -> new RuntimeException(""));
        if(param.getTitle() != null) {
            faq.setTitle(param.getTitle());
        }
        if(param.getContent() != null) {
            faq.setContent(param.getContent());
        }
        faqRepository.save(faq);
    }
    @Override
    public void delete(Long id) {
        Faq faq = faqRepository.findById(id).orElseThrow(() -> new RuntimeException(""));
        faqRepository.delete(faq);
    }

    public FaqDto.DetailResDto entityToDto(Faq faq){
        //돌려줄 디티오에 정보를 담아보겠습니다. (실제로는 Mapper를 사용할 것이라, 이렇게는 잘 안씀)
        FaqDto.DetailResDto res = new FaqDto.DetailResDto();
        res.setId(faq.getId());
        res.setTitle(faq.getTitle());
        res.setContent(faq.getContent());
        //사용자 id 값을 가져올수 있다니!!!
        Long userId = faq.getUserId();
        res.setUserId(userId);
        return res;
    }

    @Override
    public FaqDto.DetailResDto detail(Long id) {
        Faq faq = faqRepository.findById(id).orElseThrow(() -> new RuntimeException(""));
        return entityToDto(faq);
    }
    @Override
    public List<FaqDto.DetailResDto> list() {
        List<FaqDto.DetailResDto> list = new ArrayList<FaqDto.DetailResDto>();
        List<Faq> faqList = faqRepository.findAll();
        for(Faq faq : faqList) {
            list.add(entityToDto(faq));
        }
        return list;
    }


}
