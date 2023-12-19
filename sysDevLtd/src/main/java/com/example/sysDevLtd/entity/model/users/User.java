package com.example.sysDevLtd.entity.model.users;
import com.example.sysDevLtd.entity.model.pos.BaseEntity;
import com.example.sysDevLtd.entity.model.users.Role;
import com.example.sysDevLtd.entity.model.users.token.Token;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@Entity
@Table(name = "_user")
public class User extends BaseEntity implements UserDetails {

  @Id
  @GeneratedValue
  private Integer userId;
  private String userName;
  @Column(unique=true)
  private String email;
  private String password;

  @Enumerated(EnumType.STRING)
  private Role role;

  @OneToMany(mappedBy = "user")
  private List<Token> tokens;



  @Override

  public Collection<? extends GrantedAuthority> getAuthorities() {
    return role.getAuthorities();
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return email;
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
}
