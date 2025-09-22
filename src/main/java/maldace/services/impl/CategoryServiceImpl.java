package maldace.services.impl;

import java.io.File;
import java.util.List;

import maldace.daos.CategoryDAO;
import maldace.daos.impl.CategoryDAOImpl;
import maldace.models.Category;
import maldace.services.CategoryService;

public class CategoryServiceImpl implements CategoryService {

	CategoryDAO categoryDao = new CategoryDAOImpl();
	@Override
	public void insert(Category category) {
		categoryDao.insert(category);
		
	}

	@Override
	public void edit(Category category) {
		Category oldCate = categoryDao.get(category.getCateid());
		oldCate.setCatename(category.getCatename());
		
		if (category.getIcon() != null) {
			// XOA ANH CU DI
			String fileName = oldCate.getIcon();
			final String dir = "E:\\upload";
			File file = new File(dir + "/category" + fileName);
			if (file.exists()) {
			file.delete();
			}
			oldCate.setIcon(category.getIcon());
			}
		
		categoryDao.edit(oldCate);

		
	}

	@Override
	public void delete(int id) {
		categoryDao.delete(id);

		
	}

	@Override
	public Category get(int id) {
		return categoryDao.get(id);

	}

	@Override
	public Category get(String name) {
		return categoryDao.get(name);

	}

	@Override
	public List<Category> getAll() {
		return categoryDao.getAll();

	}

	@Override
	public List<Category> search(String keyword) {
		return categoryDao.search(keyword);

	}

}
