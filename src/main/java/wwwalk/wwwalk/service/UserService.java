package wwwalk.wwwalk.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wwwalk.wwwalk.entity.User;
import wwwalk.wwwalk.repository.UserRepository;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final SessionManager sessionManager;

    public void join(User user) {
        validateDuplicateMember(user.getId());
        user.setPassword(loginHashing(user.getPassword()));

        userRepository.save(user);
    }

    public String login(String id, String password) {
        Optional<User> findUser = userRepository.findById(id);

        if(findUser.isEmpty()) {
            throw new IllegalStateException("해당 회원이 존재하지 않습니다.");
        }

        if(!findUser.get().getPassword().equals(loginHashing(password))) {
            throw new IllegalStateException("비밀번호가 일치하지 않습니다.");
        }

        String uuid = UUID.randomUUID().toString();
        sessionManager.putId( uuid, id);
        log.info("로그인 완료, id={}, uuid={}", id, uuid);
        return uuid;
    }


    public String convertUuidToId(String uuid) {
        return sessionManager.getId(uuid);
    }



    private void validateDuplicateMember(String uuid) {
        Optional<User> findUser = userRepository.findById(uuid);
        if(!findUser.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    private String loginHashing(String before) {
        String sha256 = "";
        try{
            MessageDigest mdSHA256 = MessageDigest.getInstance("SHA-256");
            mdSHA256.update(before.getBytes("UTF-8"));
            byte[] sha256Hash = mdSHA256.digest();

            StringBuffer hexSHA256hash = new StringBuffer();
            for(byte b : sha256Hash){
                String hexString = String.format("%02x",b);
                hexSHA256hash.append(hexString);
            }
            sha256 = hexSHA256hash.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        return sha256;
    }

}
