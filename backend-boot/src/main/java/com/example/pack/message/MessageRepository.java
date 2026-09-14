package com.example.pack.message;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.pack.message.dto.MessageChatDto;

public interface MessageRepository extends JpaRepository<MessageJpaEntity, Integer> 
{
        
        public List<MessageJpaEntity> findAllByGroupUuid(UUID groupUuid);
        
        // native sql will parse your ZonedDateTime into Instant
        // @Query(value = """
        //         SELECT  
        //                 m.content, 
        //                 u.name,
        //                 m.user_uuid, 
        //                 m.timestamp
        //         FROM message m
        //         LEFT JOIN m_user u
        //         ON u.uuid = m.user_uuid
        //         WHERE m.group_uuid = :groupUuid
        //         """, nativeQuery = true)

        @Query("""
                SELECT  
                        m.content,
                        u.name,
                        m.userUuid,
                        m.timestamp
                FROM MessageJpaEntity m
                LEFT JOIN UserJpaEntity u
                ON u.uuid = m.userUuid
                WHERE m.groupUuid = :groupUuid
                """)
        List<MessageChatDto> findAllByGroupUuid2(@Param("groupUuid") UUID groupUuid);

}
