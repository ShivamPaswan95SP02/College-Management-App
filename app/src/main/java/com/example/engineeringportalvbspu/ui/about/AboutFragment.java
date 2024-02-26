package com.example.engineeringportalvbspu.ui.about;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.engineeringportalvbspu.R;

import java.util.ArrayList;
import java.util.List;

public class AboutFragment extends Fragment {

    private ViewPager viewPager;
    private BranchAdapter adapter;
    private List<BranchModel> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_about, container, false);

        list = new ArrayList<>();
        list.add(new BranchModel(R.drawable.ic_comp,"Information Technology","The Department of Information Technology was established in 2001 with an annual intake of sixty students. This undergraduate program is of 4 years duration with the first year spread over two semesters which is common to all the branches. The Department offers a broad curriculum including: Database Management, Software Engineering, Artificial Intelligence, Data mining, Computer Graphics, Advanced Internet Technology, Computer Networks, Operating System, Data Structures, Distributed System and Algorithms as the main courses and other courses in collaboration with the other departments of the institute at the undergraduate level. The department is managed by dedicated and experienced faculty." ));

        list.add(new BranchModel(R.drawable.ic_comp,"Computer Science","The Department of Computer Science & Engineering was established to meet the demand for well-qualified computer professionals and was conceived in the year 1997. The Department offers B.Tech (Computer Science & Engineering), M.Tech (Computer Science & Engineering) and Ph. D. (Computer Science & Engineering). The program focuses on theoretical computer science as well as software and application development. Department has well qualified and vibrant faculty dedicated for the betterment of the students. Most of the students passed out are well placed or have opted for higher studies. The department has provided a well-equipped computer lab with latest computer software. The Laboratories are installed with broad-band internet facility. The annual intake of the department is sixty students. The department ensures that program objectives are constantly met and learning outcomes are monitored through periodical test and assignment."));
        list.add(new BranchModel(R.drawable.ic_elec,"Electrical Engineering","The Electrical Engineering discipline aims to provide quality education with stress on strong foundations and thorough understanding of the basic principles that underlie modern electrical and electronic technology. The discipline has qualified and experienced faculty members, along with e-learning facilities like teleconferencing, virtual classroom program and online access to all reputed international journals. With an emphasis on green technology, the discipline pursues a holistic approach in ensuring that the students are sensitive to the environmental, safety and economic context of their coursework. The department is highly benefitted by the latest teaching aids. Developing the technology for a better and faster tomorrow is the motto that the discipline encourages. At par, we are improving ourselves to become best university in our country."));
        list.add(new BranchModel(R.drawable.ic_mech,"Mechanical Engineering","The Department was established in 1997 to cater the needs of B. Tech 1st year students of other engineering disciplines. It started its own B. Tech degree course in 2002 with an intake of 60 students. Seven batches have already passed with good placements in many national and international organizations. Many have qualified GATE and CAT examinations to continue higher studies for post-graduation from IIT, IIM and other reputed institutes. The Department is looking for its own postgraduate program (M. Tech.) in CAD/CAM, for which Board Of Studies (B.O.S.) has already passed the proposal. The Department is blessed with admission of highest rankers of UPSEE (Entrance Test) for last few years, as job opportunities in the Mechanical sector of industries has shown great demand of employment which is expected to continue for next decade as well. The curriculum of the Department is so designed that the students could be offered the updated knowledge of the field."));

        adapter = new BranchAdapter(getContext(), list);

        viewPager = view.findViewById(R.id.viewPager);

        viewPager.setAdapter(adapter);

        ImageView imageView = view.findViewById(R.id.college_image);

        Glide.with(getContext())
                .load("https://firebasestorage.googleapis.com/v0/b/engineering-portal-vbspu.appspot.com/o/slider_Image%2Fslider1.png?alt=media&token=ef7694b1-9e13-4f2e-bccb-849e150f0072")
                .into(imageView);

        return view;
    }
}