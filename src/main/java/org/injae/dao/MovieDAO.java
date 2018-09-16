package org.injae.dao;

import org.injae.domain.MovieVO;

import java.util.ArrayList;
import java.util.List;


public class MovieDAO {

    public List<MovieVO> getList() {
        final List<MovieVO> list = new ArrayList<MovieVO>();
        final String sql = "select * from tbl_movie_review";          //sql문 뒤에 세미콜론 안됨

        new QueryExecutor() {
            @Override
            public void doJob() throws Exception {
                stmt = con.prepareStatement(sql);
                rs = stmt.executeQuery();
                while (rs.next()) {
                    MovieVO vo = new MovieVO();
                    vo.setMno(rs.getInt("mno"));
                    vo.setMimg(rs.getString("mimg"));
                    vo.setCmt(rs.getString("cmt"));
                    vo.setMtitle(rs.getString("mtitle"));
                    list.add(vo);
                }
            }
        }.executeAll();

        return list;
    }

    public MovieVO getReview(final int mno) {
        final MovieVO vo = new MovieVO();
        final String sql = "select * from tbl_movie_review where mno = ?";

        new QueryExecutor() {
            public void doJob() throws Exception {
                stmt = con.prepareStatement(sql);
                stmt.setInt(1,mno);
                rs = stmt.executeQuery();
                while(rs.next()){
                    vo.setMno(rs.getInt("mno"));
                    vo.setMimg(rs.getString("mimg"));
                    vo.setCmt(rs.getString("cmt"));
                    vo.setMtitle(rs.getString("mtitle"));
                }
            }
        }.executeAll();

        //code
        return vo;
    }

    public void addReview(final MovieVO vo) {
        final String sql = "insert into tbl_movie_review (mno, mtitle, cmt, mimg)\n" +
                "values ( seq_movie_review.nextval, ?, ?, ?)";
        //mnum, score, cmt
        new QueryExecutor() {
            public void doJob() throws Exception {
                stmt = con.prepareStatement(sql);
                stmt.setString(1, vo.getMtitle());
                stmt.setString(2, vo.getCmt());
                stmt.setString(3,vo.getMimg());
                stmt.executeUpdate();
            }
        }.executeAll();
    }

    public void deleteReview(final int mno) {
        final String sql = "delete from tbl_movie_review where mno = ?";

        new QueryExecutor() {
            public void doJob() throws Exception {
                stmt = con.prepareStatement(sql);
                stmt.setInt(1,mno);
                stmt.executeUpdate();
            }
        }.executeAll();
    }

    public void updateReview(final int mno,final MovieVO vo) {
        final String sql = "update tbl_movie_review set mtitle = ?, cmt = ?, mimg = ? where mno= ?";

        new QueryExecutor() {
            public void doJob() throws Exception {
                stmt = con.prepareStatement(sql);
                stmt.setString(1,vo.getMtitle());
                stmt.setString(2,vo.getCmt());
                stmt.setString(3,vo.getMimg());
                stmt.setInt(4,mno);
            }
        }.executeAll();
    }
}
