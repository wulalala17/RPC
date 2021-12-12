package common;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * 用java自带的序列化方式，实现接口
 */

@Data
@Builder
public class RPCRequest implements Serializable {
    private String interfaceName;
    private String methodName;
    private Object[] params;
    private Class<?>[] paramsTypes;
}
