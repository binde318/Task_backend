package com.binde.Backend.service.serviceImpl;

//@Service
//@AllArgsConstructor
//public class AuthServiceImpl implements AuthService {
//    private UserRepository userRepository;
//    private RoleRepository roleRepository;
//    private PasswordEncoder passwordEncoder;
//    private AuthenticationManager authenticationManager;
//    @Override
//    public String register(RegisterDto registerDto) {
//// check username is already exists in database
//        if(userRepository.existsByUsername(registerDto.getUsername())){
//            throw new BookApiException(HttpStatus.BAD_REQUEST, "Username already exists!");
//        }
//
//        // check email is already exists in database
//        if(userRepository.existsByEmail(registerDto.getEmail())){
//            throw new BookApiException(HttpStatus.BAD_REQUEST, "Email is already exists!.");
//        }
//
//         User user = new User();
//        user.setName(registerDto.getName());
//        user.setUsername(registerDto.getUsername());
//        user.setEmail(registerDto.getEmail());
//        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
//
//        Set<Role> roles = new HashSet<>();
//        Role userRole = roleRepository.findByName("ROLE_USER");
//        roles.add(userRole);
//
//        user.setRoles(roles);
//
//        userRepository.save(user);
//
//        return "User Registered Successfully!.";
//    }
//
//    @Override
//    public String login(LoginDto loginDto) {
//
//        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
//                loginDto.getUsernameOrEmail(),
//                loginDto.getPassword()
//        ));
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        return "User logged-in successfully!.";
//    }
//}
