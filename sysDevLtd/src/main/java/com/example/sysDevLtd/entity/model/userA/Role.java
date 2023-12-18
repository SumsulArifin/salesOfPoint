package com.example.sysDevLtd.entity.model.userA;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import static com.example.sysDevLtd.entity.model.userA.Permission.*;

@RequiredArgsConstructor
public enum Role {

  USER(Collections.emptySet()),
  ADMIN(
          Set.of(
                  ADMIN_READ,
                  ADMIN_UPDATE,
                  ADMIN_DELETE,
                  ADMIN_CREATE,
                  TEACHER_CREATE,
                  TEACHER_UPDATE,
                  TEACHER_READ,
                  TEACHER_DELETE
          )
  ),
  TEACHER(
          Set.of(
                  TEACHER_CREATE,
                  TEACHER_UPDATE,
                  TEACHER_READ
          )
  ),
  STUDENT(
          Set.of(
                  STUDENT_READ,
                  STUDENT_CREATE

          )
  )
  ;

  @Getter
  private final Set<Permission> permissions;
  public List<SimpleGrantedAuthority> getAuthorities() {
    var authorities = getPermissions()
            .stream()
            .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
            .collect(Collectors.toList());
    authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
    return authorities;
  }
}
