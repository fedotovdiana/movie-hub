package ru.itis.moviehub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.itis.moviehub.models.State;
import ru.itis.moviehub.models.User;
import ru.itis.moviehub.repositories.UsersRepository;

import java.util.Optional;

@Service
public class ConfirmServiceImpl implements ConfirmService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HttpHeaders headers;

    @Override
    public boolean confirm(String confirmCode) {
        Optional<User> userOptional = usersRepository.findByConfirmCode(confirmCode);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setState(State.CONFIRMED);
            usersRepository.save(user);

//            sms
            headers.setBasicAuth("diana.fedotova.2000@mail.ru", "BteGOsg8EB7VwgPJScAuboq0C3mM");
            String resourceUrl =
                    "https://@gate.smsaero.ru/v2/sms/send?number=79869202913&text=Ваш аккаунт подтвержден&sign=SMS Aero&channel=DIRECT";
            HttpEntity<String> entity = new HttpEntity<>(headers);
            ResponseEntity<String> response = restTemplate.exchange(resourceUrl, HttpMethod.GET, entity, String.class);
            System.out.println(response.getBody());

            return true;
        }
        return false;
    }
}
