//package ru.itis.moviehub.services;

//
//@Service
//public class SignInServiceImpl implements SignInService {
//
//    @Autowired
//    private UsersRepository usersRepository;
//
//    @Autowired
//    private CookieValuesRepository cookieValuesRepository;
//
//    @Override
//    public String signIn(String login, String password, Boolean isNeedCookie) {
//        Optional<User> userOptional = usersRepository.findByLogin(login);
//
//        String value = null;
//        if (isNeedCookie) {
//            if (userOptional.isPresent() && userOptional.get().getHashPassword().equals(password)) {
//                value = UUID.randomUUID().toString();
//                CookieValue cookieValue = CookieValue.builder()
//                        .value(value)
//                        .user(userOptional.get())
//                        .build();
//                cookieValuesRepository.save(cookieValue);
//            }
//        }
//        return value;
//    }
//}
