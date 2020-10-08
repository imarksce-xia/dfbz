package com.xgb.dao;

import com.xgb.entity.Meeting;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.List;

/**
 * @author iMarksce
 * @date 2020/9/26
 * @Description
 */
public class MeetingDao extends BaseDao {

    public List<Meeting> listPage(String title, Integer page) {
        String sql = "select m.*,d.name deptName from meeting m left join dept d on d.id = m.dept_id where title like ? limit ?,3";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Meeting.class), "%" + title + "%", (page - 1) * 3);
    }

    public void addMeeting(Meeting meeting) {
        String sql = "insert into meeting values(null,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, meeting.getDeptName(), meeting.getDeptId(), meeting.getTitle(),
                meeting.getContent(), meeting.getPublishDate(), meeting.getStartTime(),
                meeting.getEndTime(), meeting.getStatus(), meeting.getMakeUser());
    }

    public Integer getCount(String title) {
        String sql = "select count(*) rowCount from meeting where title like ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, "%" + title + "%");
    }

    public List<Meeting> listAll() {
        String sql = "select m.*,d.name deptName from meeting m left join dept d on d.id = m.dept_id";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Meeting.class));
    }

    public void updateStatusById(Meeting meeting) {
        String sql = "update meeting set status = ? where id = ?";
        jdbcTemplate.update(sql, meeting.getStatus(), meeting.getId());
    }

    public Meeting getMeetingById(Integer id) {
        String sql = "select * from meeting where id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Meeting.class), id);
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Integer> listUserId(Integer meetingId) {
        String sql = "select user_id from meeting_join where meeting_id=?";
        return jdbcTemplate.queryForList(sql, Integer.class, meetingId);
    }

    public void joinMeeting(Integer meetingId, Integer userId) {
        String sql = "insert into meeting_join value (?,?)";
        jdbcTemplate.update(sql, meetingId, userId);
    }

    public void delMeeting(Integer meetingId, Integer userId) {
        String sql = "delete from meeting_join where meeting_id = ? and User_id = ?";
        jdbcTemplate.update(sql, meetingId, userId);
    }
}
