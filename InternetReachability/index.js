
import { NativeModules } from 'react-native';
import {Platform} from 'react-native';

const { RNInternetReachability } = NativeModules;


export const isReachable = async (timeout?: Number, domain?: String) => {
    timeout = timeout ? timeout : 5000;
    domain = domain ? domain : '8.8.8.8';

	return new Promise((resolve, reject) => {
		RNInternetReachability.isReachable(timeout, domain)
			.then(result => {
				if (Platform.OS === 'ios') {
					resolve(result === 1 ? true : false)
				} else {
					resolve(result)
				}
			})
			.catch(error => {
				resolve(false)
			})
	}).catch(error => { alert('err : ' + error.message); });
}

export default {
	isReachable,
}
