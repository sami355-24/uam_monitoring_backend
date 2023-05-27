package uammonitoring.server.Service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uammonitoring.server.Entity.uam;
import uammonitoring.server.Repository.uamRepository;
import uammonitoring.server.Service.uamService;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class uamServiceImpl implements uamService {

    private final uamRepository repository;

    @Override
    public List<String> getUamList() {
        List<String> returnValue = new ArrayList<>();
        List<uam> result = repository.findAll();
        for (uam data : result)
            returnValue.add(data.getName());

        return returnValue;
    }
}
