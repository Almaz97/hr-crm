package io.zensoft.share.service.model;

import io.zensoft.share.model.Post;
import org.springframework.stereotype.Service;

/**
 * Created by temirlan on 6/29/18.
 */
@Service
public interface PostService {
    void save(Post postDto);
}
