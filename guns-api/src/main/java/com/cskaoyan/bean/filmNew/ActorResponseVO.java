package com.cskaoyan.bean.filmNew;

import lombok.Data;
import org.omg.PortableServer.ServantRetentionPolicy;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: yyc
 * @Date: 2019/6/10 20:32
 */
@Data
public class ActorResponseVO implements Serializable {
    private ActorVO director;
    private List<ActorVO> actors;
}
