package com.board.back.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="user")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@DynamicInsert
@DynamicUpdate
@Getter
public class User extends BaseTime  implements UserDetails{
	@Id //primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //������Ʈ���� ����� db�� �ѹ��� ������ ����
	private long id;
	
	@Column(nullable = false, length=30, unique = true)
	private String username; //���̵�
	
	@Column(nullable = false, length=300)
	private String password; //�ؽ��� ��ȣȭ �ϱ� ������ �˳��ϰ� �ۼ�
	
	@Column(nullable = false, length=50)
	private String email;
	
	@Enumerated(EnumType.STRING)
	private RoleType role; 
	
	@ColumnDefault("'N'")
	@Column(name = "del_yn", length = 1)
	private String delYn;
	
	
	public void setPassword(String password) { this.password = password; }
	
	@Builder
    public User(Long id, String username, String email, String password, RoleType role) {
        // this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }
	
	 //계정이 갖고있는 권한 목록은 리턴
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        
        Collection<GrantedAuthority> collectors = new ArrayList<>();
        collectors.add(() -> {
            return this.role.toString();
        });
        
        //collectors.add(new SimpleGrantedAuthority("Role"));
        
        return collectors;
    }
    
	//계정이 만료되지 않았는지 리턴 (true: 만료 안됨)
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //계정이 잠겨있는지 않았는지 리턴. (true: 잠기지 않음)
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    //비밀번호가 만료되지 않았는지 리턴한다. (true: 만료 안됨)
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //계정이 활성화(사용가능)인지 리턴 (true: 활성화)
    @Override
    public boolean isEnabled() {
        return true;
    }
}
