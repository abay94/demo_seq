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
    public static String getNextValue(String name) {
        char[] chars = name.toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean carry = true;
        for (int i = chars.length - 1; i >= 0; i=i-2) {
            char character = chars[i-1];
            char digit = chars[i];
            if (carry) {
                if (character == 'z' && digit == '9') {
                    carry = true;
                    chars[i-1] = 'a';
                    chars[i] = '0';
                } else if (character != 'z' && digit == '9') {
                    carry = false;
                    chars[i-1]++;
                    chars[i] = '0';
                } else if (character == 'z' && digit != '9') {
                    carry = false;
                    chars[i-1] = 'a';
                    chars[i]++;
                } else {
                    carry = false;
                    chars[i]++;
                }
            }

            sb.append(chars[i]);
            sb.append(chars[i-1]);
        }
        if (carry) {
            sb.append("0a");
        }

        return sb.reverse().toString();
    }
}
