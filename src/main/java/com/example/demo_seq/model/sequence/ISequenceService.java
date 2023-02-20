package com.example.demo_seq.model.sequence;

import com.example.demo_seq.service.SequenceService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@Transactional(rollbackOn = Throwable.class)
@RequiredArgsConstructor
public class ISequenceService implements SequenceService {

    private final SequenceRepository sequenceRepository;

    @Override
    public String updateValue() {
        Sequence sequence = sequenceRepository.findByName(Sequence.Name.LAST_INDEX);
        sequence.setValue(getNextValue(sequence.getValue()));
        Sequence updated = sequenceRepository.save(sequence);
        return updated.getValue();
    }


    // helpers
    public String getNextValue(String name) {
        return name + "1";
    }
}
