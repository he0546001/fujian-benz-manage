package fujian.benz.manage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import fujian.benz.manage.base.mapper.IBaseMapper;
import fujian.benz.manage.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.List;
 
public  class BaseServiceImpl<T> implements BaseService<T> {

    @Autowired
	private IBaseMapper<T> mapper;
	
	private Class<T> clazz;
	
	@SuppressWarnings("unchecked")
	public BaseServiceImpl(){
		//this是当前实例化的对象（**ServiceImpl）--- BaseServiceImpl<**>
		ParameterizedType pt = (ParameterizedType)this.getClass().getGenericSuperclass();
		
		clazz = (Class<T>)pt.getActualTypeArguments()[0];
	}
	//根据id查询
	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
	public T queryById(Serializable id){
		return mapper.selectByPrimaryKey(id);
	}



    //根据条件查询
	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
	public List<T> queryListByWhere(T t){
		return mapper.select(t);
	}
	
	//查询所有
	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
	public List<T> queryAll(){
		return mapper.selectAll();
	}
	
	//根据example条件查询
	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
	public List<T>queryByExample(Example example){
		List<T>list=mapper.selectByExample(example);
		return  list;
	}
	
	/**
	 * 根据分页条件查询
	 * @param t 查询条件
	 * @param page 页号
	 * @param rows 页大小
	 * @return 分页对象
	 */
	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
	public PageInfo<T> queryPageByWhere(T t, Integer page, Integer rows){
		//分页设置
		PageHelper.startPage(page, rows);
		List<T> list = mapper.select(t);
		
		return new PageInfo<T>(list);
	}
	
	/**
	 * 根据分页复杂查询
	 * @param example 查询条件对象
	 * @param page 页号
	 * @param rows 页大小
	 * @return 分页对象
	 */
	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
	public PageInfo<T> queryPageByExample(Example example, Integer page, Integer rows){
		//分页设置
		PageHelper.startPage(page, rows);
		
		List<T> list = mapper.selectByExample(example);
		
		return new PageInfo<T>(list);
	}
	
	//选择性新增
	@Transactional(rollbackFor=RuntimeException.class)
	public void save(T t){
		mapper.insertSelective(t);
	}
	
	//根据主键选择性更新
	@Transactional(rollbackFor=RuntimeException.class)
	public void update(T t){
		mapper.updateByPrimaryKeySelective(t);
	}
	
	//根据主键删除
	@Transactional(rollbackFor=RuntimeException.class)
	public void deleteById(Serializable id){
		mapper.deleteByPrimaryKey(id);
	   
	}
	
	//根据主键集合批量删除
	@Transactional(rollbackFor=RuntimeException.class)	
	public void deleteByIds(Object[] ids){
			//创建查询对象
		 Example example = new Example(clazz);
					
		 Criteria criteria = example.createCriteria();
					
		 criteria.andIn("id", Arrays.asList(ids));
					
		 mapper.deleteByExample(example);
		}

    //根据example 查询数量
	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
	public int queryCount(Example example){                //查询数量
		 return mapper.selectCountByExample(example);
		}
}
