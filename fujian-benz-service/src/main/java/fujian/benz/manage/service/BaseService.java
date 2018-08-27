package fujian.benz.manage.service;


import com.github.pagehelper.PageInfo;
import tk.mybatis.mapper.entity.Example;

import java.io.Serializable;
import java.util.List;

/**
 * Created by john on 2018/8/24.
 */
public interface BaseService<T> {


    T queryById(Serializable id);

    List<T> queryListByWhere(T t);

    List<T> queryAll();

    List<T>queryByExample(Example example);

    PageInfo<T> queryPageByWhere(T t, Integer page, Integer rows);

    PageInfo<T> queryPageByExample(Example example, Integer page, Integer rows);

   void save(T t);
   
   void update(T t);
    
   void deleteById(Serializable id);

    void deleteByIds(Object[] ids);

    int queryCount(Example example);

}
