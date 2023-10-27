package ptithcm.WebMovie.Security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ptithcm.WebMovie.Model.Role;
import ptithcm.WebMovie.Model.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MovieUserDetails implements UserDetails {
    private User user;
    public MovieUserDetails(User user){
        this.user = user;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Role role = user.getRole();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public int getUserId() {
        return user.getUserId();
    }


    public String getUserName() {
        return user.getUserName();
    }


    public String getName() {
        return user.getName();
    }


    public String getEmail() {
        return user.getEmail();
    }




    public String getAvatar() {
        return user.getAvatar();
    }

}
