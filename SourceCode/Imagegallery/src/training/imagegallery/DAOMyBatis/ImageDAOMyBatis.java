package training.imagegallery.DAOMyBatis;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;

import training.imagegallery.DAO.ImageDAO;
import training.imagegallery.model.Image;
import training.imagegallery.util.MybatisSessionFactory;

public class ImageDAOMyBatis implements ImageDAO{
	
	@Override
	public List<Image> listImage(){
		SqlSession session = MybatisSessionFactory.openSession();
		try{
			ImageDAO imageDAO = session.getMapper(ImageDAO.class);
			return imageDAO.listImage();
		}finally{
			session.close();
		}
		
	}
	
	@Override
	public Image getImage(int id){
		SqlSession session = MybatisSessionFactory.openSession();
		try{
			ImageDAO imageDAO = session.getMapper(ImageDAO.class);
			return imageDAO.getImage(id);
		}finally{
			session.close();
		}
		
	}
	
	@Override
	public List<Image> SearchImageFullText(String key){
		SqlSession session = MybatisSessionFactory.openSession();
		try{
			ImageDAO imageDAO = session.getMapper(ImageDAO.class);
			return imageDAO.SearchImageFullText("%" + key.trim() + "%");
		}finally{
			session.close();
		}
		
	}
	
	@Override
	public Image getImageById(int id) {
		SqlSession session = MybatisSessionFactory.openSession();
		try{
			ImageDAO imageDAO = session.getMapper(ImageDAO.class);
			return imageDAO.getImageById(id);
		}finally{
			session.close();
		}
		
	}
	
	public void insertImage(Image image) throws FileNotFoundException{
		SqlSession session = MybatisSessionFactory.openSession();
		try{
			ImageDAO imageDAO = session.getMapper(ImageDAO.class);
			imageDAO.insertImage(image);
			session.commit();
		}finally{
			session.close();
		}
	}
	
	@Override
	public void updateImage(Image image) {
		// TODO Auto-generated method stub
		SqlSession session = MybatisSessionFactory.openSession();
		try{
			ImageDAO imageDAO = session.getMapper(ImageDAO.class);
			imageDAO.updateImage(image);
			session.commit();
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
	public void updateFileImage(int id, File file) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public List<Image> SearchImage(String name, String description,
			String date, String user_Update, String category_Name) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int getSquence() {
		// TODO Auto-generated method stub
		return 0;
	}

}
