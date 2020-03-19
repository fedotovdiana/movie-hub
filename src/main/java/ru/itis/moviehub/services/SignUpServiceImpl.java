package ru.itis.moviehub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.moviehub.dto.SignUpDto;
import ru.itis.moviehub.models.Role;
import ru.itis.moviehub.models.State;
import ru.itis.moviehub.models.User;
import ru.itis.moviehub.repositories.UsersRepository;

import java.util.UUID;

@Component
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private EmailService emailService;

    @Override
    public void signUp(SignUpDto form) {
        User user = User.builder()
                .login(form.getLogin())
                .password(form.getPassword())
                .name(form.getName())
                .state(State.NOT_CONFIRMED)
                .role(Role.USER)
                .confirmCode(UUID.randomUUID().toString())
                .build();

        usersRepository.save(user);

        emailService.sendMail("Confirm", user.getName(), user.getConfirmCode(), user.getLogin());
    }
}
//    Part p = request.getPart("photo");
//    String localdir = "uploads";
//    String pathDir = getServletContext().getRealPath("") + File.separator + localdir;
//    File dir = new File(pathDir);
//        if (!dir.exists()) {
//                dir.mkdir();
//                }
//                String[] filename_data = p.getSubmittedFileName().split("\\.");
//                String filename = Math.random() + "." + filename_data[filename_data.length - 1];
//                String fullpath = pathDir + File.separator + filename;
//                p.write(fullpath);
//                String photo = "" + localdir + "/" + filename;
//
//                Cookie cookie = new Cookie("user", login);
//                cookie.setMaxAge(60 * 60 * 24 * 14);
//                response.addCookie(cookie);
//                try {
//                userService.register(name, login, password, photo);
//                } catch (NoSuchAlgorithmException e) {
//                e.printStackTrace();
//                }
//                User user = userService.getUser(login);
//                request.getSession().setAttribute("user", user);
//                response.sendRedirect("/films");