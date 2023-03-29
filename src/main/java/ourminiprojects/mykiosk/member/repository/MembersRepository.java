package ourminiprojects.mykiosk.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ourminiprojects.mykiosk.member.dto.Members;

public interface MembersRepository extends JpaRepository<Members, Long> {
    Members findByPhoneNumber(String phoneNumber);
}
