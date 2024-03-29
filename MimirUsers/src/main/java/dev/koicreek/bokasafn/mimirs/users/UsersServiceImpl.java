package dev.koicreek.bokasafn.mimirs.users;

import dev.koicreek.bokasafn.mimirs.users.contracts.response.GetUserResponseCM;
import dev.koicreek.bokasafn.mimirs.users.contracts.response.UserCreationResponseCM;
import dev.koicreek.bokasafn.mimirs.users.contracts.UserRegistrationCM;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final UsersDAO usersDAO;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserCreationResponseCM createUser(UserRegistrationCM userRequest) {
        UserEntity userEntity = new UserEntity(userRequest);
        userEntity.setEncryptedPassword(passwordEncoder.encode(userRequest.getPassword()));
        try {
            this.usersDAO.save(userEntity);
        } catch(DataIntegrityViolationException ex) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
//        System.out.println(userEntity);
        return new UserCreationResponseCM(userEntity);
    }

    @Override
    public GetUserResponseCM getUserByPublicId(String publicId) {
        UserEntity userEntity = usersDAO.findByPublicId(publicId);

        if(userEntity == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST ,"User not found");

        return new GetUserResponseCM(userEntity);
    }

    //#region SpringSecurity

    @Override
    public UserEntity loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = usersDAO.findByUsername(username);
        if(user == null) throw new UsernameNotFoundException(username);
        return user;
    }

    //#endregion

}
