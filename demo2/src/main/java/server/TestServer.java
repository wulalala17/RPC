package server;

import service.BlogService;
import service.ServiceImpl.BlogServiceImpl;
import service.ServiceImpl.UserServiceImpl;
import service.UserService;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestServer {
    public static void main(String[] args){
        UserService userService = new UserServiceImpl();
        BlogService blogService = new BlogServiceImpl();

//        Map<String, Object> serviceProvide = new HashMap<>();
//        serviceProvide.put("com.ganghuan.myRPCVersion2.service.UserService",userService);
//        serviceProvide.put("com.ganghuan.myRPCVersion2.service.BlogService",blogService);
        ServiceProvider serviceProvider = new ServiceProvider();
        serviceProvider.provideServiceInterface(userService);
        serviceProvider.provideServiceInterface(blogService);

        RPCServer RPCServer = new ThreadPoolRPCRPCServer(serviceProvider);
        RPCServer.start(8899);
    }
}
