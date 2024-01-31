import http from 'k6/http';
import { sleep } from 'k6';

export const options = {
    vus: 100,
    duration: '240s',
};

export default function () {
    http.get('http://encryptor:8080/api/encryptor');
    sleep(1);
}
