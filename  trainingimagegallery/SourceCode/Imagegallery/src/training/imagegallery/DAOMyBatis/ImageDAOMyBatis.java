package training.imagegallery.DAOMyBatis;

import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;

import training.imagegallery.DAO.ImageDAO;
import training.imagegallery.model.Image;
import training.imagegallery.util.MybatisSessionFactory;

public class ImageDAOMyBatis implements ImageDAO{
	public List<Image> listImage(){
		SqlSession session = MybatisSessionFactory.openSession();
		try{
			ImageDAO imageDAO = session.getMapper(ImageDAO.class);
			return imageDAO.listImage();
		}finally{
			session.close();
		}
		
	}
	public Image getImage(int id){
		SqlSession session = MybatisSessionFactory.openSession();
		try{
			ImageDAO imageDAO = session.getMapper(ImageDAO.class);
			return imageDAO.getImage(id);
		}finally{
			session.close();
		}
		
	}
	
	public List<Image> searchImageFullText(String key){
		SqlSession session = MybatisSessionFactory.openSession();
		try{
			ImageDAO imageDAO = session.getMapper(ImageDAO.class);
			return imageDAO.searchImageFullText("%" + key.trim() + "%");
		}finally{
			session.close();
		}
		
	}
	public Image getImageEdit(int id){
		SqlSession session = MybatisSessionFactory.openSession();
		try{
			ImageDAO imageDAO = session.getMapper(ImageDAO.class);
			return imageDAO.getImageEdit(id);
		}finally{
			session.close();
		}
		
	}
	public int insertImage(Image image){
		SqlSession session = MybatisSessionFactory.openSession();
		try{
			ImageDAO imageDAO = session.getMapper(ImageDAO.class);
			int count = imageDAO.insertImage(image);
			session.commit();
			return count;
		}finally{
			session.close();
		}
	}
	public int UpdateImage(Image image){
		SqlSession session = MybatisSessionFactory.openSession();
		try{
			ImageDAO imageDAO = session.getMapper(ImageDAO.class);
			int count = imageDAO.updateImage(image);
			session.commit();
			return count;
		}finally{
			session.close();
		}
	}
	public void deleteImage(int id){
		SqlSession session = MybatisSessionFactory.openSession();
		try{
			ImageDAO imageDAO = session.getMapper(ImageDAO.class);
				imageDAO.deleteImage(id);
			session.commit();
		}finally{
			session.close();
		}
	}
	@Override
	public void setDataSource(DataSource dataSource) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int updateImage(Image image) {
		// TODO Auto-generated method stub
		return 0;
	}
}
