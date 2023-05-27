package uammonitoring.server.Service;

import org.springframework.stereotype.Service;
import uammonitoring.server.Entity.uam;

import java.util.List;

public interface uamService {

    public List<String> getUamList();
}
