package com.example.demo_seq.controller.sequence;

import com.example.demo_seq.controller.sequence.dto.SequenceDto;
import com.example.demo_seq.service.SequenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "v1/sequence")
public class SequenceController {

    private final SequenceService sequenceService;

    @GetMapping
    public SequenceDto getSequence() {
        String lastIndex = sequenceService.updateValue();
        return new SequenceDto(lastIndex);
    }
}
