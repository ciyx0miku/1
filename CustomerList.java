/**
 * CustomerList为Customer提供对象的管理模块
 * 内部数组管理一组Customer对象，并提供相应的添加、修改、删除和遍历方法 供CustomerView调用
 */
public class CustomerList {
    private Customer[] customers;// 用来保存客户对象的数组
    private int total = 0;// 记录已保存客户对象的数量

    /**
     * 用途：构造器，用来初始化customers数组
     * @param totalCustomer  指定customers数组的最大空间
     */
    public CustomerList(int totalCustomer){
        customers = new Customer[totalCustomer];
    }

    /**
     * 用途：将参数customer添加组中最后一个客户对象记录之后
     * @param customer customer指定要添加的客户对象
     * @return 添加成功返回true；false表示数组已满，无法添加
     */
    public boolean addCustomer(Customer customer){
        if (total < 0 || total >= customers.length){
            return false;
        }
        customers[total] = customer;
        total++;
        return true;
    }

    /**
     * 用途：用参数customer替换数组中由index指定的对象
     * @param index index指定替换的对象在数组中的位置，从0开始
     * @param customer customer指定替换的新客户对象
     * @return 替换成功返回true；false表示索引无效，无法替换
     */
    public boolean replaceCustomer(int index , Customer customer){
        if(index < 0 || index >= total){
            return false;
        }
        customers[index] = customer;
        return true;
    }

    /**
     * 用途：删除下标为index的数组对象
     * @param index 要删除对象的下标
     * @return 删除成功返回true；false表示索引无效，无法删除
     */
    public boolean deleteCustomer(int index){
        if(index < 0 || index >= total){
            return false;
        }
        for (int i = index;i < total -1;i++){
            customers[i] = customers[i+1];
        }
        //customers[total-1] = null;
        //total--;
        //或者
        customers[--total] = null;
        return true;
    }

    /**
     * 用途：获取所有客户信息
     * @return 实际的对象个数而不是整个数组的长度
     */
    public Customer[] getAllCustomers(){
        Customer[] custs = new Customer[total];
        for (int i = 0;i < total;i++){
            custs[i] = customers[i];
        }
        return custs;
    }

    /**
     * 用途：获取索引为index位置上个对象信息
     * @param index 要获取对象的下标
     * @return 索引为index位置上个对象
     */
    public Customer getCustomer(int index){
        if (index < 0 || index >= total){
            return null;
        }
        return customers[index];
    }

    /**
     * 用途：获取存储的对象个数
     * @return
     */
    public int getTotal(){
        return total;
    }
}
